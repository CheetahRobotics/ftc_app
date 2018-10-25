## Vuforia

### Introduction
Vuforia is a library that allows the robot to track its own coordinates in the field by using its relative position to images in fixed locations.

### Preliminary investigation

#### Thursday, October 25
_Nathan - can you write up a short summary (a few sentences) about what we looked at today? You may also be able to expand the introduction I started above, or add other sections you think might be of interest_

Next steps:
* Carefully read the implentation of the ConceptVuforiaNavRoverRuckus class, including all of the comments. This contains enough information to help us understand the orientation of the field and the robot without forcing to understand the mathematical concepts that Vuforia uses in its calculations.
* Reread the implementation again, this time drawing the field and the robot, labeling the axes, and identifying where the 4 images will be located in relation to other landmarks (e.g. the audience). Work through the explanations of how the transformations describe the position of the images and the camera.
* Obtain a license key. From a comment in the file above:
> A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer web site at https://developer.vuforia.com/license-manager.
* Create a new directory 'vuforiaop' as a sibling to the 'teleop' in the TeamCode directory. Create a new file there, and essentially copy the contents of the ConceptVuforiaNavRoverRuckus. We will need to add our own key, and we will need to change some of the configuration parameters related to the position of the camera on the robot.
* Try to build the code and deploy it to the robot. See if we can position the robot where it can see one of the images and have the control center display the robot's coordinates.
