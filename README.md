# b3-r7-r4nd7
This is my solution for the b3-r7-r4nd7 challenge from https://www.get-in-it.de/coding-challenge

# How it works
The organizers provided a json file containing nodes and edges that represent a graph. The goal was to find the shortest/fastest path from the node "Erde" to "b3-r7-r4nd7" in that graph.
My implementation creates maps the data model in Java by reading and parsing that json file using [Gson](https://github.com/google/gson) and calculates the shortest path using the Dijkstra algorthim.

# Solution
Running the code outputs the following solution:
```
Path:
Erde -> node_810 -> node_595 -> node_132 -> node_519 -> node_71 -> node_432 -> b3-r7-r4nd7

Total cost: 
2.995687895999458
```
