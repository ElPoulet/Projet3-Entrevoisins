package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "5 rue du pigeon", "06 15 45 45 12","www.facebook.fr/caroline", false),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e", "5 rue du chemin vert", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f", "15 rue du chat", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c","5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d","5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline",false),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline", false),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d", "5 rue du pigeon", "06 15 45 45 12", "www.facebook.fr/caroline",false)
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }

}
