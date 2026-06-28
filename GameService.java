package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // ADDED: Required for Iterator Pattern

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1; // ADDED

	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1; // ADDED

	// FIXME: Add missing pieces to turn this class a singleton
	private static GameService service = null;

	// private constructor
	private GameService() {

	}

	// created the single GameService instance
	// CHANGED: renamed method to getInstance() to follow Singleton convention
	public static GameService getInstance() {

		// only add the new instance
		// otherwise, return the single instance
		if (service == null) {

			service = new GameService();

		}

		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found return the existing instance

		// CHANGED: Using Iterator Pattern instead of searching through getGame()
		Iterator<Game> iterator = games.iterator();

		while (iterator.hasNext()) {

			Game existingGame = iterator.next();

			if (existingGame.getName().equalsIgnoreCase(name)) {

				game = existingGame;
				break;
			}
		}

		// If game does not already exist, create it
		if (game == null) {

			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * 
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// If found, simply assign that instance to the local variable

		// CHANGED: Iterator Pattern implementation
		Iterator<Game> iterator = games.iterator();

		while (iterator.hasNext()) {

			Game OldGame = iterator.next();

			if (OldGame.getId() == id) {

				game = OldGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// If found assign that instance to the local variable

		// CHANGED: Iterator Pattern implementation
		Iterator<Game> iterator = games.iterator();

		while (iterator.hasNext()) {

			Game OldGame = iterator.next();

			if (OldGame.getName().equalsIgnoreCase(name)) {

				game = OldGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}

