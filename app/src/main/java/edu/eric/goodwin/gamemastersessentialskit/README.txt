Point Distribution and Sources
Activity: 1 pt                   - Main Activity
Fragment: 2 pts                  -  Menu Screen, Dice Roller Screen
Drawables: 3 (maybe 2?) pts      -  GM Logo, App Icon, Large icon on notification (converted app icon to bitmap)
layout.xml files: 3 pts          - activity_main, dice_list_layout, fragment_dice_roller, initial_screen
Animations: ?, 2 maybe           -  button flash? Not counting in my calculations
SQLite: 2 pts                    - 1 table
Data structure/class: 3 pts      - DBHelper, DiceRollsPersistence, DiceRollsSchema, DiceRollerModel,
                                   DiceRollerViewFragment, DiceRolls (data class for sqlite), MainActivity, MenuScreenViewFragment,
                                   MyNotificationPublisher,  NotifioncationGenerator
Interface/abstract classes: 2 pts - ButtonListeners in DiceRollerViewFragment and MenuScreenViewFragment
RecyclerView,Holder,Adapter:3 pts - In DiceRollerViewFragment
notifications: 4 pts (maybe 2)    - Well sort of 2.  Really its the same with a different message depending on
what triggered it.  It only occurs when the following coditions are met : players get either a 20 or a 1 on a d20 roll
if only 1 d20 was rolled to get that.  Rolling a "natural" 20 or 1 in Dungeons and Dragons is a special rule.  If this
app were ever to be finished, it would be changed so that all players in the group received that notification when
someone got  20 or a 1 but since this is all local right now, it just pops up for who got it.
