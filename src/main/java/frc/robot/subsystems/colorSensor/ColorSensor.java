package frc.robot.subsystems.colorSensor;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.colorSensor.Enum.GamePiece;

import java.awt.*;

public class ColorSensor extends SubsystemBase {
    private static ColorSensor instance;
    private GamePiece lastGamePiece;
    private final ColorSensorComponnents componnents;

    public ColorSensor() {
        this.componnents = new ColorSensorComponnentsImpl();
        this.lastGamePiece = GamePiece.NONE;
    }


    public Color getColor() {
        return componnents.getColorSensor().getColor();
    }

    public int getRed() {
        return componnents.getColorSensor().getRed();
    }

    public int getBlue() {
        return componnents.getColorSensor().getBlue();
    }

    public int getGreen() {
        return componnents.getColorSensor().getGreen();
    }
    public int getProximity() {
        return componnents.getColorSensor().getProximity();
    }
    public GamePiece getLastGamePiece() {
        return lastGamePiece;

        }

    }


