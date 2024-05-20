# Augmented Reality Navigation for Indoor Spaces

## Overview

This project implements a basic simulation of Augmented Reality (AR) Navigation for Indoor Spaces in Java. The system helps users navigate through indoor spaces by providing directions based on a predefined map of points of interest (POIs) and paths. Although the AR visualization and real-time user tracking are not covered in this basic implementation, the core logic for pathfinding and navigation is demonstrated.

## Features

- **Indoor Space Representation:** Models an indoor space using points of interest (rooms, hallways) and paths between them.
- **Pathfinding:** Implements Dijkstra's algorithm to find the shortest path between two points of interest.
- **Simulation of User Movement:** Allows the simulation of movement from one point to another within the indoor space.

## Getting Started

1. **Clone the Repository:**
    
    ```bash
    git clone <https://github.com/yourusername/ar-indoor-navigation.git>
    
    ```
    
2. **Compile and Run:**
    
    ```bash
    cd ar-indoor-navigation
    javac IndoorNavigationSystem.java
    java IndoorNavigationSystem
    
    ```
    
3. **Follow On-Screen Instructions:**
    
    The program will simulate the creation of an indoor space map with points of interest and paths. It will then find and display the shortest path between specified points of interest.
    

## Usage

1. **Define Points of Interest:**
    
    The system allows the definition of various points of interest (e.g., rooms, hallways) within an indoor space.
    
2. **Add Paths:**
    
    Paths connecting these points of interest can be added, with distances representing the real-world distances between these points.
    
3. **Find Shortest Path:**
    
    The system uses Dijkstra's algorithm to find the shortest path between two specified points of interest and displays the path.
    

## Sample Output

When you run the program, you will see output similar to the following:

```
Trying to Mine block 1...
Block Mined!!! : <hash_of_block_1>

Trying to Mine block 2...
Block Mined!!! : <hash_of_block_2>

Trying to Mine block 3...
Block Mined!!! : <hash_of_block_3>

Blockchain is Valid: true

Block:
Hash: <hash_of_block_1>
Previous Hash: 0
Data: Transaction 1 Data
Timestamp: <timestamp_of_block_1>

Block:
Hash: <hash_of_block_2>
Previous Hash: <hash_of_block_1>
Data: Transaction 2 Data
Timestamp: <timestamp_of_block_2>

Block:
Hash: <hash_of_block_3>
Previous Hash: <hash_of_block_2>
Data: Transaction 3 Data
Timestamp: <timestamp_of_block_3>

```

## Contributors

- Jeel patel
