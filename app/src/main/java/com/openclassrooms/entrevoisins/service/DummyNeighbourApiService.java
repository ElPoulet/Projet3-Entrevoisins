package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() { return neighbours; }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavNeighbours() { return neighbours; }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changeFavoriteNeighbour(Neighbour neighbour){
        if(neighbours.get(neighbours.indexOf(neighbour)).getFavorite()==false)
            neighbours.get(neighbours.indexOf(neighbour)).setFavorite(true);
        else neighbours.get(neighbours.indexOf(neighbour)).setFavorite(false);
    }


}
