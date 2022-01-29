# LDTS 2021/2022 - Tetris

## Group G1505 elements

| Name                 | Number    | E-Mail                 |
| -------------------- | --------- | ---------------------- |
| Dinis Sousa          | 202006303 |up202006303@edu.fe.up.pt|
| Francsica Silva      | 202005140 |up202005140@edu.fe.up.pt|
| Miguel Teixeira      | 202005208 |up202005208@edu.fe.up.pt|

## Design Patterns

### Facade

#### Problem
We are using a framework called Lanterna to use as our GUI framework for the game. This framework has more method than we need to use and in order to render an object on screen sometimes long segments of code are needed. If we called the Lanterna methods directcly in our code it would be much harder to read or mantain

#### Solution
> The Facade Pattern: A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts. A facade might provide limited functionality in comparison to working with the subsystem directly. However, it includes only those features that clients really care aboout, in our case, the methods that can render the diffrent components of our game!

#### Implementetion
![Facade](uml/Facade.png)

**The classes can be found in the following files:**
> [GUI](../src/main/java/Tetris/gui/GUI.java)
> 
> [Lanterna GUI](../src/main/java/Tetris/gui/LanternaGUI.java)

### Singleton

#### Problem
In our project, there classes of which it is not supposed to exist more than one instance of that class. For example, in a game like Tetris you do not want the main object to be created more than once, as you are supposed to play a "game" at a time in the same device. Moreover, the class Music in our project loads the music that can be listened in our game everytime it is constructed, by having it as a Singleton, it will only load the music file once.

#### Solution
> The Singleton Pattern: Creating a singleton is achieved in two steps, making the constructor private and create a getInstance() method that returns the instance of the class if it already exists or creates a new instance if it does not exist yet.

#### Implementation
![Singleton](uml/Singleton.png)

**The classes can be found in the following files:**
> [Main](../src/main/java/Tetris/Main.java)
>
> [Music](../src/main/java/Tetris/model/game/Music.java)
