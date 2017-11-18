# WTFClass-Versions
V1.0  Simple one class program that writes keyboard input in a file
V2.0  Addition of class Person that now holds the info in object variables
V3.0  Creation of FileManipulator class that contains only a static method
      that deals with writing arguments passed into the file or appending 
      to it.
V3.1  Enhancement of FileManipulator class. Added readFile function that 
      can read from a file passed as argument all the lines. Also enhanced 
      People class with an extra setter and getter that can set or get any
      object variable depending on an int modifier also passed.
V3.11 Added extra functionality to FileManipulator. Overloaded readFile so
      now if passed a start line and a finish line it only prints the lines
      from start till finish.Added extra test lines in main() to demonstrate
      the new features.
V4.0  Overloaded writeString() function in FileManipulator class so allows 
      us to make a series of new folders to an extra argument path and then 
      create the file there.The path is specified in a People class static
      constant field named PATH and can be altered accordingly
V4.1  Added the function populatePersonObjectFromFile() in FileManipulator
      class that returns a Person object reference when called with initialized
      fields as specified by the format of the file saved through writeString()
      of Person class. Currently only works for the specific format. 
      Needs to be improved so it can work on different formats if possible
v4.11 Modified function populatePersonObjectFromFile() in FileManipulator
      so it simplifies the manipulation of the read content to extract the 
      data.
v4.2  Changed the abstract class FilemManipulator of v4.11 into an interface of
      static methods that other classes like Person can implement.

