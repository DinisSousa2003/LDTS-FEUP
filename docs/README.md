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
*Insert photo of facade*

**The classes can be found in the following files:**
> [GUI](../src/main/java/Tetris/gui/GUI.java)
>
> [Lanterna GUI](../src/main/java/Tetris/gui/LanternaGUI.java)
