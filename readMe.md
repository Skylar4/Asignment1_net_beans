# Sorting Program

This sorting program provides a variety of sorting algorithms implemented in Java. The available sorting algorithms include Quick Sort and other utilities for sorting polygons.

## Installation

1. **Clone the Repository**

   ```sh
   git clone <repository-url>

2. **Navigate to the Project Directory**

    cd <project-directory>

3. **Compile the Java Files**

    javac -d bin src/utilities/*.java src/polygons/*.java src/appDomain/*.java

## Usage 

1. **Run the Sorting Program**

    • -f or -F followed by file_name (the file name and path) with no spaces
    • -t or -T followed by v (volume), h (height) or a (base area) with no spaces
    • -s or -S followed by b (bubble), s (selection), i (insertion), m (merge), q (quick) or z
    (your choice of sorting algorithm) with no spaces

    eg.
    • java -jar Sort.jar -fshapes1.txt -Tv -Sb
    • java -jar Sort.jar -ta -sQ -f"res\shapes1".txt
    • java -jar Sort.jar -tH -F"C:\temp\shapes1.txt" –sB

# Documentation
    /doc/index.html

# License 

This README covers the basics: cloning the repository, compiling the code, running the program, and a simple usage example.
