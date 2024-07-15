#
# This is the user-interface definition of a Shiny web application. You can
# run the application by clicking 'Run App' above.
#
# Find out more about building applications with Shiny here:
#
#    http://shiny.rstudio.com/
#

library(shiny)
library(plotly)

source("intro_tab.R")
source("plot_tab.R")

# Define UI for application that draws a histogram
shinyUI(navbarPage(
  "Assignment 4", # application title
  intro,         # include the first page content
  plot         # include the second page content
  )
)
