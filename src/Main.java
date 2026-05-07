void main() {
    MyGraph g = new MyGraph(7);

    System.out.println("Graph list: ");
    g.addEdge('A', 'C');
    g.addEdge('A', 'B');
    g.addEdge('A', 'D');
    g.addEdge('B', 'C');
    g.addEdge('B', 'E');
    g.addEdge('B', 'G');
    g.addEdge('C', 'D');
    g.addEdge('E', 'G');
    g.addEdge('E', 'F');
    g.addEdge('F', 'G');

    g.printGraph();

    System.out.println("Task 1");
    g.dfs(); //In depth first search we go in-depth until we hit the node that has no child node,
    // then we go back to the last intersection and in-depth search it and so on until we search the
    // whole graph. So the order will be:
    //A -> C -> B -> E -> G -> F -> D

    System.out.println("Task 2");
    g.bfs('A'); //In the breadth first search we search every node adjacent to our starting
    //node, then select those nodes and search all of their adjacent nodes. so the order will be like:
    //A -> C -> B -> D -> E -> G -> F
    System.out.println();

    System.out.println("Task 4: shortest path of weighted graph is: ");
    Node Edinburgh = new Node("Edinburgh");
    Node Glasgow = new Node("Glasgow");
    Node Stirling = new Node("Stirling");
    Node Perth = new Node("Perth");
    Node Dundee = new Node("Dundee");

    Edinburgh.addDestination(Glasgow, 70);
    Edinburgh.addDestination(Stirling, 50);
    Edinburgh.addDestination(Perth, 100);

    Glasgow.addDestination(Edinburgh, 70);
    Glasgow.addDestination(Stirling, 50);

    Stirling.addDestination(Edinburgh, 50);
    Stirling.addDestination(Glasgow, 50);
    Stirling.addDestination(Perth, 40);

    Perth.addDestination(Stirling, 40);
    Perth.addDestination(Edinburgh, 100);
    Perth.addDestination(Dundee, 60);

    Dundee.addDestination(Perth, 60);

    WeightGraph graph = new WeightGraph();
    graph.addNode(Edinburgh);
    graph.addNode(Glasgow);
    graph.addNode(Perth);
    graph.addNode(Stirling);
    graph.addNode(Dundee);

    graph = Dijkstra.calculateShortestPathFromSource(graph, Edinburgh);
    for (Node node : Dundee.getShortestPath()){
        System.out.print(node.getName() + " -> ");
    }
    System.out.println(Dundee.getName());
}
