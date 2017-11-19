package main

class WeightedGraph {

    private val vertexes = mutableMapOf<Int, MutableMap<Int, Int>>()

    fun add(name :Int){
        vertexes.put(name, mutableMapOf())
    }

    fun makeNeighbors(first: Int, second: Int, weight: Int){
        if (vertexes.containsKey(first) && vertexes.containsKey(second)){
            vertexes[first]!!.put(second, weight)
            vertexes[second]!!.put(first, weight)
        } else {
            throw NoSuchElementException()
        }
    }

    fun getNeighbors(vertex: Int): MutableMap<Int, Int> {
        if (vertexes.containsKey(vertex)) {
            return vertexes[vertex]!!
        } else {
            throw NoSuchElementException()
        }
    }
}