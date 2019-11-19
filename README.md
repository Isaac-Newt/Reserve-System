# Reserve-System
System to model a library's reserve item circulation system

## Coding Style

I generally use the following coding style. Feel free to write code in whatever style you prefer, but if you're looking for a style, I've found this to be quite clear and readable. 

```Java
package package_name;

import java.util.ArrayList;

public class ClassName {

    // Declare data members
    private int myNumber;
    private String myString;

    // Main method
    public static void main(String[] args) {
        // Method documentation comment
        System.out.println("Hello World");
    }

    // Constructor method
    public ClassName(int number, String string) {
        this.myNumber = number;
        this.myString = string;
    }

}
```

Basically, I leave space around the methods in the class, and have comments for each section of the class (data members, constructor, getters/setters, other methods). I also generally use alternating capitals for variable names (myNumber, myString), with a lowercase starting the name.

## File Naming

I'm following the Eclipse recommendations here, package name is lowercase, class names start with a capital letter. I have README's in the source directories.