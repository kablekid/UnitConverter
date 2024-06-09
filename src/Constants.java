public class Constants {
     final static int FrameHeight = 650;
     final static int FrameWidth = 700 ;



     final static int TopPanelHeight = FrameHeight/10;
     final static int TopPanelWidth =  FrameWidth;


     final static int TopPanelX = 0;
     final static int TopPanelY =  0;


     final static int CatagoryPanelHeight = FrameHeight - TopPanelHeight;
     final static int CatagoryPanelWidth =  (int) (FrameWidth*0.3);

     final static int CatagoryPanelX = TopPanelX;
     final static int CatagoryPanelY = TopPanelHeight;


     final static int UnitSelectionPanelWidth = FrameWidth - CatagoryPanelWidth ;
     final static int UnitSelectionPanelHeight = 385;

     final static int UnitSelectionPanelX = CatagoryPanelWidth;
     final static int UnitSelectionPanelY = TopPanelHeight;


     final static int OutputPanelWidth = UnitSelectionPanelWidth;
     final static int OutputPanelHeight= FrameHeight - TopPanelHeight - UnitSelectionPanelHeight;


     final static int OutputPanelX = CatagoryPanelWidth;
     final static int OutputPanelY = 450;


}
class Units{

    final static String[] Length = {"miles", "centimeters", "meters", "millimeters", "inches", "yards", "feet",
                                   "kilometers", "nautical miles", "micrometers", "nanometers", "angstroms"};

    final static String[] Temperature = {"kelvin", "celsius", "fahrenheit"};

    final static String[] Area = {"square kilometers", "square meters", "square centimeters", "square millimeters",
                                   "hectares", "acres", "square feet", "square yards"};

    final static String[] Volume = {"liters", "cubic meters", "milliliters", "gallons", "cubic feet", "fluid ounces"};

    final static String[] Weight = {"grams", "kilograms", "milligrams", "pounds", "ounces", "tons"};

    final static String[] Data = {"bytes", "kilobytes", "megabytes", "gigabytes", "terabytes", "petabytes", "exabytes"};

    final static String[] Currency = {"USD", "EUR", "JPY", "CNY", "GBP", /* Add more as needed */};

    final static String[] Speed = {"meters per second", "kilometers per hour", "miles per hour", "knots"};

    final static String[] Time = {"seconds", "minutes", "hours", "days", "weeks", "months", "years"};

    final static String[] Pressure = {"pascals", "bars", "atmospheres", "torr", "pounds per square inch"};

    final static String[] Acceleration = {"meters per second squared", "kilometers per hour per second", "g-force"};

    final static String[] defaultChoice = {"Selct Catagory"};


}