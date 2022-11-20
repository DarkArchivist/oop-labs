package util;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public final class Constants {
    public final static Timer timer = new Timer();
    public final static Random rand = new Random();

    public static TimerTask wrap(Runnable r) {
        return new TimerTask() {
            @Override
            public void run() {
                r.run();
            }
        };
    }

    private Constants() {}

    public static final String[] firstNames = new String[] {
            "Cornel",
            "Dan",
            "Alex",
            "Vasile",
            "Igor",
            "Bogdan",
            "Mihai",
            "Gheorghe",
            "Andrei",
            "Eugen"
    };

    public static final String[] lastNames = new String[] {
            "Nastas",
            "Romaniuc",
            "Babin",
            "Zgirvaci",
            "Random",
            "Coliban",
            "Dascal",
            "Profir",
            "Laurel",
            "Calin",
    };

    public static final String[] vins = new String[] {
            "2B3CL3CG6BH614968",
            "1C3CCBABXCN282384",
            "4T1BF1FK0CU622872",
            "1N6DD26S92C373336",
            "3D7KR26D38G179779",
            "1C3CDZAGXDN770236",
            "KMHDH4AE1FU301630",
            "JN8AF5MR8DT226143",
            "JTEGF21A430087692",
            "1FDKF37G5TEB09925",
            "JN8AF5MR2DT209046",
            "4JGBB8GB8BA659347",
            "3CZRE3H31AG704384",
            "1J8FF28W98D515606"
    };

    public static final String[] banks = new String[] {
            "Maib",
            "VictoriaBank",
            "Moldtelecom",
            "Micb"
    };

    public static final String[] addresses = new String[] {
            "2067 Emeral Dreams Drive",
            "3011 Clinton Street",
            "593 Morgan Street",
            "4270 Jadewood Drive",
            "4341 Birch  Street",
            "3137 Ingram Road",
            "384 Quincy Street",
            "255 Kuhl Avenue",
            "285 Clover Drive",
            "2893 Crim Lane",
            "922 Havanna Street",
            "442 Elm Drive",
            "1799 Oakmound Road"
    };
}