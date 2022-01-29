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

### State Pattern

#### Problem
A game works like a finite-state machine. At any given time, a game can only be in some given state. On the case of Tetris, you can be either in the Menu, seeing the Rules, playing the actual Game or sad because you are on the GameEnd. One could use conditional logic to change between the states. However, not only that would be harder to read and maintain, but it would also be violation of the Single Responsibility Principle and the Open Closed Principle.

### Solution
Create a classes for all the different states. All the different states implement the same State interface. This allows the Main to render different Views and have the user work on different Controllers by only knowing in which state it is.

### Implementation
![State Pattern](uml/State_Factory.drawio.png)

**The classes can be found in the following files:**
> [Main](../src/main/java/Tetris/Main.java)
>
> [State](../src/main/java/Tetris/states/State.java)
> 
> [MenuState](../src/main/java/Tetris/states/MenuState.java)
> 
> [GameState](../src/main/java/Tetris/states/GameState.java)
>
> [RulesState](../src/main/java/Tetris/states/RulesState.java)
> 
> [EndGameState](../src/main/java/Tetris/states/EndGameState.java)


### Factory Method Pattern

#### Problem
Imagine that you have a method that needs to return objects of different classes each time it is called. When applying the State Pattern we ran into that problem. For each different state, we needed the methods getController() and getViewer() to return objects of different classes. But how can we do this?

#### Solution
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. That way, the same State interface can return different Controllers and Viewers and needed.

#### Implementation
![Factory Pattern](uml/State_Factory.drawio.png)

**The classes can be found in the following files:**
> [State](../src/main/java/Tetris/states/State.java)
>
> [MenuState](../src/main/java/Tetris/states/MenuState.java)
>
> [GameState](../src/main/java/Tetris/states/GameState.java)
>
> [RulesState](../src/main/java/Tetris/states/RulesState.java)
>
> [EndGameState](../src/main/java/Tetris/states/EndGameState.java)

### Game Loop Pattern

### Problem
In a game like Tetris, the game should loop continuously during gameplay.

#### Solution
For each turn of the loop, it processes user input without blocking, updates the game state, and renders the game. It tracks the passage of time to control the rate of gameplay. The game loop makes it possible for the game to run smoothly regardless of a user's input, or lack thereof. It also allows an easier frame rate management. 

#### Implementation
![Game Loop](uml/GameLoop.png)

### MVC Architecture

### Problem
In the game of Tetris, or more broadly, in any given game or application that uses a Graphical User Interface to communicate with the user, how can the different components be separated?

#### Solution
A common solution to this is the use of the MVC Architecture (also known as Model-View-Controller), which consists in dividing the application in three parts (the model, the view and the controller).

**Model** - Contains purely the application information, and it is independent of the GUI. In the case of Tetris, the game model for example stores the Tetrimino's information, what blocks are on the board and where, how many points the user has, etc...

**Viewer** - This part is the one that helps the user to visualize the model data. The view calls the GUI to represent the model data in a way that the user can interact with.

**Controller** - Most of the work is done by the controller. It converts the user inputs in commands for the application, which result in changes to the model.

#### Implementation
![MVC](uml/MVC.png)

**The Model Classes can be found in the following files:**
> [Color](../src/main/java/Tetris/model/Color.java)
> 
> [Position](../src/main/java/Tetris/model/Position.java)
> 
> **End Game Model**
> 
> [EndGame](../src/main/java/Tetris/model/EndGame.java)
> 
> **Menu Model**
> 
> [Menu](../src/main/java/Tetris/model/Menu.java)
> 
> **Game Model**
> 
> [Block](../src/main/java/Tetris/model/game/Block.java)
> 
> [Board](../src/main/java/Tetris/model/game/Board.java)
> 
> [Music](../src/main/java/Tetris/model/game/Music.java)
> 
> [QueueOfTetriminos](../src/main/java/Tetris/model/game/QueueOfTetriminos.java)
> 
> [Screen](../src/main/java/Tetris/model/game/Screen.java)
> 
> [Stats](../src/main/java/Tetris/model/game/Stats.java)
> 
> [Tetrimino](../src/main/java/Tetris/model/game/Tetrimino.java)
> 
> [TetriminoDirection](../src/main/java/Tetris/model/game/TetriminoDirection.java)
> 
> [Tetriminos](../src/main/java/Tetris/model/game/Tetriminos/)
> 
> **Rules Model**
> 
> [Rules](../src/main/java/Tetris/model/rules/Rules.java)