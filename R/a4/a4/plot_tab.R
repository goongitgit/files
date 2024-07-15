library("shiny")
library("plotly")

plot <- tabPanel(
  "Visualization", # label for the tab in the navbar
  titlePanel("Dynamic Plot"), # show with a displayed title
  
  # This content uses a sidebar layout
  sidebarLayout(
    sidebarPanel(
      sliderInput("sliderrange", label = h3("Slider Range for Year"), sep = "", min = 1990, 
                  max = 2020, value = c(1990, 2020)),
      checkboxGroupInput("checkmark", label = h3("Variable Selection"), 
                         choices = list("co2" = 1, "methane" = 2), selected = c(1, 2)),
    ),
    mainPanel(
      plotlyOutput("co2plot"), 
      h3("Chart Purpose"),
      p("In order to understand Methane's effects on global emissions, I summarized world data by year and compared the methane
          emissions growth to the co2 growth over a large time period. Waht I found was that the CO2 emissions have gone up noticeably, increasing by 
        3000+ million metric tons, whereas the methane co2 equivalent emissions had incread by 1000+ million metric tons. While at first glance it may seem that methane
        iis not something to worry about, after some research, it is easy to see that is not the case. While CO2 makes up about 40k million metric tons,
        methane still makes almsot 1/4 of that amount at around ~10k million metric tons. This is especially dangerous as the US EPA has stated that
        Methane is more dangerous than CO2. \"Methane is more than 25 times as potent as carbon dioxide at trapping heat in the atmosphere. Over the last two centuries, 
        methane concentrations in the atmosphere have more than doubled, largely due to human-related activities.\" In conclusion, through the plotting and comparison
        of CO2 and Methane growth, we can better understand how to tackle the issue of climate change.")
    )
  )
)