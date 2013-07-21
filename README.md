RubiksCube
==========

Rubik's Cube Java applet

author: Gaurav Mangal, Ankush Agrawal

Colors:
    The following are the numbers within the 3D array in the program that
    correspond to colors on the Rubik's cube. This information is in the 
    documentation of the program itself, but is copied here as well:

    1 - White
    2 - Yellow
    3 - Red
    4 - Orange
    5 - Green
    6 - Blue

Faces:
    The first dimension of the array that holds the cube refers to the different
    faces of the cube. The indices map as follows:

    0 - Up
    1 - Down
    2 - Front
    3 - Back
    4 - Left
    5 - Right

TODO:
    Implement createPanelArray method by manually mapping panels to indices in
        the 3D array.
    Create an undo button using a Stack
    Create clickListeners for all the buttons
    **Optional** Improve efficiency by manually writing each rotation method 
        instead of calling other rotation methods

