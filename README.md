# Custom Item

A Minecraft plugin for giving a player a custom item on join which executes a command on right click.

## Versions Supported

- Minecraft 1.8 and above

## Installation

1. Download the plugin JAR file.
2. Drag and drop the JAR file into your **plugins** folder.

## Dependencies

- **Placeholder API**

## Configuration

Below is an example configuration file:

```yaml
# Custom Item Configuration
#    _____ _          _ _____  _
#   |  __ (_)        | |  __ \| |
#   | |__) |__  _____| | |__) | | __ _ _   _ ____
#   |  ___/ \ \/ / _ \ |  ___/| |/ _` | | | |_  /
#   | |   | |>  <  __/ | |    | | (_| | |_| |/ /
#   |_|   |_/_/\_\___|_|_|    |_|\__,_|\__, /___|
#                                       __/ |
#                                      |___/

world:
  enabled: "false"  # Enable if the custom item is given only for a specific world
  name: "world"     # Name of the world

# Maximum 9 items supported

item1:
  enabled: "true"
  # Example items: ACACIA_DOOR, COMPASS, etc.
  Item: "EMERALD"         # Name of the item (no spaces)
  SlotNumber: 1           # Slot number (1-9)
  ItemName: "&aSERVER SELECTOR"  # Display name for the item
  ItemLore:
    - "&fClick To"
    - "&lOpen"
  Command: "say hi"       # Command to execute (without the leading slash)

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

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).

