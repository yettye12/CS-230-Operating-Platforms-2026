package com.gamingroom;

/**
 * Base class for all game entities.
 * Stores the common id and name attributes.
 */
public class Entity {

    private long id;
    private String name;

    /**
     * Default constructor.
     */
    public Entity() {
    }

    /**
     * Constructor with id and name.
     *
     * @param id unique identifier
     * @param name unique name
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the entity id.
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the entity name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}