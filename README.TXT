------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Balloon Defence 3

PURPOSE OF PROJECT: ICS4U Final Project

VERSION or DATE: Jan 21, 2022

HOW TO START THIS PROJECT: Press Play Button on greenfoot

AUTHORS: Aninda Saha, Conrad Mo

USER INSTRUCTIONS: Balloon Defence 3 is a top down shooter style game. The player
is a money, and the goal is to survive as many waves of enemies as possible. The enemies,
which are multicoloured balloons with different stats, will keep following the player 
until they lose of all their health. There are three unique worlds with differing difficulty:
the Grasslands (world 1), the Desert (world 2), and the Graveyard (world 3). As you 
defeat the balloons, you get gold, which allows you to get epic upgrades for your
monkey to further your chances of lasting against the balloons. Try your hardest to 
get to a new high wave!

CRITERIA:
Recursion can be found in two different locations: GameWorld class and HighScoresScreen
class. Within GameWorld, recursion is used to have a balloon spawner which randomly
spawns balloons on the edges of the playable world. Within HighScoresScreen, it is
used in quicksort, which has been modified to work with arraylists designed to keep hold 
of player high scores/waves(quicksort is SORTING, RECURSIVE and uses DATA STRUCTURES).
Another data structure used was a stack, which was used in Health class as the health
for the player. When a balloon touches the player it pops the stack and updates the value
as it is an object within the game screen.

CHEAT CODES/CHEATS:
<O>: Kills the player. (Can only use while playing in any of the 3 levels)
<B> + <M>: Adds 1000 gold to wallet (Can only use in ShopWorld/shop screen)
