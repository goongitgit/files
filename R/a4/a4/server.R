#
# This is the server logic of a Shiny web application. You can run the
# application by clicking 'Run App' above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library("shiny")
library("tidyverse")
library("ggplot2")
library("plotly")

co2data <- read.csv("https://raw.githubusercontent.com/owid/co2-data/master/owid-co2-data.csv")

exclude <- c("World", "Asia", "Africa", "North America", "South America", "Europe", "Australia")

#1. Which country had the highest methane emission over all time? China
country_highest_methane <- co2data %>%
  filter(is.na(methane) != TRUE) %>%
  filter(country %in% exclude != TRUE) %>%
  group_by(country) %>%
  select(country, methane) %>%
  summarise(methane = sum(methane, na.rm =TRUE)) %>%
  filter(methane == max(methane, na.rm = TRUE)) %>%
  pull(country)

#2. What was the highest amount of co2 emitted by a country over all time? 416,723 metric tons
country_highest_co2 <- co2data %>%
  filter(is.na(co2) != TRUE) %>%
  filter(country %in% exclude != TRUE) %>%
  group_by(country) %>%
  select(country, co2) %>%
  summarise(co2 = sum(co2, na.rm =TRUE)) %>%
  filter(co2 == max(co2, na.rm = TRUE)) %>%
  pull(co2)

#3. What has been the total change for methane over all time? 1032.45 metric tons
begin_methane <- co2data %>%
  filter(is.na(methane) != TRUE) %>%
  filter(country %in% exclude != TRUE) %>% 
  group_by(year) %>%
  summarise(methane = sum(methane, na.rm = TRUE)) %>%
  filter(year == min(year, na.rm = TRUE)) %>%
  pull(methane)

end_methane <- co2data %>%
  filter(is.na(methane) != TRUE) %>%
  filter(country %in% exclude != TRUE) %>%
  group_by(year) %>%
  summarise(methane = sum(methane, na.rm = TRUE)) %>%
  filter(year == max(year, na.rm = TRUE)) %>%
  pull(methane)

change_methane_all_time <- end_methane - begin_methane

#4. Which country currently produces the most co2? China
country_highest_co2_current <- co2data %>%
  filter(is.na(co2) != TRUE) %>%
  filter(country %in% exclude != TRUE) %>%
  filter(year >= 2015) %>%
  group_by(country) %>%
  select(country, co2) %>%
  summarise(co2 = sum(co2, na.rm =TRUE)) %>%
  filter(co2 == max(co2, na.rm = TRUE)) %>%
  pull(country)

#5. Which country currently has the greatest share of co2 emissions? China
country_highest_co2_share_current <- co2data %>%
  filter(is.na(share_global_co2) != TRUE) %>%
  filter(country %in% exclude != TRUE) %>%
  filter(year >= 2015) %>%
  group_by(country) %>%
  select(country, share_global_co2) %>%
  summarise(share_global_co2 = sum(share_global_co2, na.rm =TRUE)) %>%
  filter(share_global_co2 == max(share_global_co2, na.rm = TRUE)) %>%
  pull(country)

# Define server logic required to draw a histogram
shinyServer(function(input, output) {

  output$co2plot<-renderPlotly({
    
    #table for plot
    co2andmethane <- co2data %>%
      filter(is.na(methane) != TRUE & is.na(co2) != TRUE) %>%
      filter(country %in% exclude != TRUE) %>%
      filter(country != "World") %>%
      filter(year > 1850) %>%
      filter(year >= input$sliderrange[1]) %>%
      filter(year <= input$sliderrange[2]) %>%
      group_by(year) %>% 
      summarise(co2 = sum(co2, na.rm = TRUE), methane = sum(methane, na.rm = TRUE)) %>%
      select(year, co2, methane)
    
    #View(co2andmethane)
    plot_ly(
      data = co2andmethane,
      x = ~year, 
      y = ~co2,
      name = "CO2 (in million tons)",
      type = "scatter",
      mode = "lines"
    ) %>% 
      layout(title = "World Total CO2 and Methane CO2 Equivalent Emissions by Year") %>%
      add_trace(y = ~methane, name = "Methane (in CO2 million tons equivalent)")
    
  })

})
