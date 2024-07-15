library("shiny")
source("server.R")

intro <- tabPanel(
  "Introduction", # label for the tab in the navbar
  titlePanel("Introduction to CO2 dataset analysis and Summary Variables"), # show with a displayed title
  h3("Introduction"),
  p("Increasingly, the climate has been being affected by the consequences of global warming. This increase in 
    global tempuratures has been caused mainly due to emissions from many different industrial and societal activities. 
    The main greenhouse gas that has been contributing to the amount of heat being trapped in the Earth's atmosphere is CO2. However, 
    CO2 isn't the only greenhouse gas that contributes to rising temperatures. In order to help analyze how different greenhouse
    gases effect emissions into the atmosphere, I have chosen to analyze 2 variables in respect to time. These two variables are:"),
  p("-co2"),
  p("-methane"),
  h3("Summary Statistics"),
  p("In order to gain a high-level understanding of the issue of global warming, I calculated several summary statistics to see what basic features of co2 and methane emissions
    include. As the dataset is highly extensive, I chose to work with the dataset at the country level for summary variables. This is because the country level gives more specificity rather than
    the broader data the continent level would provide. The following are the summary questions and their respective answers, with a brief analysis
    at the end:"),
  p(paste0("1. Which country had the highest methane emission over all time? ", country_highest_methane)),
  p(paste0("2. What was the highest amount of co2 emitted by a country over all time? ", country_highest_co2, "million metric tons")),
  p(paste0("3. What has been the total change for methane over all time? ", change_methane_all_time, "million metric tons")),
  p(paste0("4. Which country currently produces the most co2? ", country_highest_co2_current)),
  p(paste0("5. Which country currently has the greatest share of co2 emissions? ", country_highest_co2_share_current)),
  p("As shown by the variables, China has been shown to be a leader in global emissions in both CO2 and Methane emissions. The sources of methane gas and co2 and the large quantity
    of it are mainly due to China's very large population. There are two aspects of China that make it the worlds leader in 
    most emissions of methane and co2. One aspect is that China has a huge population, and as such has huge energy needs, and to generate the necessary energy,
    large amounts of CO2 are emitted as a byproduct.Secondly, As China has a huge population, it requires a lot of livestock. However, such large amounts
    of livestock emit large amounts of methane gas. This is shown even in the US, as the US had millions of livestock around the nation. Another important point about
    the summary statistics regard the methane change over time. In the chart explanation, I will further explain how methane affects the environment. ")
  
)