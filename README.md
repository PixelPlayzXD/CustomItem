# Custom Item

A Minecraft Plugin For Giving A Player A Custom Item On Join Which Executes A Command On Right Click

### Versions Supported

1.8 - Current

## Installation

Installation is very simple

- Drag And Drop The Plugin JAR File Inside Your **plugins** Folder

## Dependencies
 - **Placeholder API** 
## Configuration
```white
#    _____ _          _ _____  _
#   |  __ (_)        | |  __ \| |
#   | |__) |__  _____| | |__) | | __ _ _   _ ____
#   |  ___/ \ \/ / _ \ |  ___/| |/ _` | | | |_  /
#   | |   | |>  <  __/ | |    | | (_| | |_| |/ /
#   |_|   |_/_/\_\___|_|_|    |_|\__,_|\__, /___|
#                                       __/ |
#                                      |___/

world:
  enabled: "false" # If The Custom Item Is Given To A Player Joining a Specific World
  name: "world" # Name Of The World


# Maximum 9 Items Supported


item1:
  enabled: "true"
  # eg: ACACIA_DOOR , COMPASS
  Item: "EMERALD" # Name Of The Item Without Space
  SlotNumber: 1 # Slot Number 1 - 9
  ItemName: "&aSERVER SELECTOR" # Name you want to give the item
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  # - "You Can Add More Lines Like This If You Want"
  Command: "say hi" # The Command To Be Executed Without " / "


item2:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 2
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item3:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 3
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item4:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 4
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item5:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 5
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item6:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 6
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item7:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 7
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item8:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 8
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"


item9:
  enabled: "false"
  Item: "EMERALD"
  SlotNumber: 9
  ItemName: "&aSERVER SELECTOR"
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"
```
## License

[MIT](https://choosealicense.com/licenses/mit/)
