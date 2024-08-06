package main.java.GUI;

import main.java.GuiComponents.*;

import javax.swing.*;
import java.awt.*;

public class AppGUI extends JFrame {
    public AppGUI()
    {
        super("Weather App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(450, 620));
        setLocationRelativeTo(null);

        setResizable(false);

        generateGradientBackground();
        setLayout(null);

        generateGuiComponents();
    }

    private void generateGuiComponents()
    {
        generateSearchFieldComponent();
        generateWeatherCondition();
        generateHumidityInformation();
    }

    private void generateSearchFieldComponent()
    {
        add(SearchField.createSearchField());
        add(SearchField.createSearchButton("assets/images/loupe.png"));
    }

    private void generateGradientBackground()
    {
        GradientPanel gradientBackground = new GradientPanel(
                new GradientGenerator(new Color(0xFFDA76), new Color(0xFF8C9E))
        );
        setContentPane(gradientBackground);
    }

    private void generateWeatherCondition()
    {
        // for now let it be cloudy sunny before i implement api
        String fileHandle = "assets/images/cloudy-sunny.png";
        WeatherImageLabelGenerator weatherImageLabelGenerator  = new WeatherImageLabelGenerator(fileHandle);

        JLabel weatherImage = weatherImageLabelGenerator.createImageLabel();
        JLabel temperatureText = TemperatureTextGenerator.generateLabel();
        JLabel weatherDescription = WeatherCondDescriptionMaker.createDescriptionLabel();

        add(weatherImage);
        add(temperatureText);
        add(weatherDescription);
    }

    private void generateHumidityInformation()
    {
        String fileHandle = "assets/images/humidity.png";
        HumidityImageDisplayer humidityImageDisplayer = new HumidityImageDisplayer(fileHandle);

        JLabel humidityImage = humidityImageDisplayer.createImageLabel();
        JLabel humidityText = HumidityTextGenerator.generateLabel();

        add(humidityImage);
        add(humidityText);
    }
}

