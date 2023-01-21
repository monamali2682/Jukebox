package com.example.demo;

import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.commands.ListSongCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.entities.Player;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final ISongRepository songRepository = new SongRepository();
            private final IPlaylistRepository playlistRepository = new PlaylistRepository();
            
            // Initialize services
            private final SongService songservice = new SongService(songRepository);
            private final PlaylistService playlistservice = new PlaylistService(playlistRepository,songRepository);
            private Player player = new Player();
            

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();
            // Initialize commands
            private final AddSongCommand addSongCommand = new AddSongCommand(songservice);
            private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistservice);
            private final AddSongToPlaylistCommand addSongToPlaylistCommand = new AddSongToPlaylistCommand(playlistservice);
            private final DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand = new DeleteSongFromPlaylistCommand(playlistservice);
            private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistservice);
            private final LoadPlaylistCommand loadPlaylistcommand = new LoadPlaylistCommand(player,playlistservice);
            private final PlaySongCommand playSongCommand = new PlaySongCommand(player);
            private final NextSongCommand nextSongCommand = new NextSongCommand(player);
            private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(player);
            private final StopSongCommand stopSongCommand = new StopSongCommand(player);
            private final ListSongCommand listSongCommand = new ListSongCommand(songservice);
            
            
            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG.getName(),addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST.getName(),createPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST.getName(),addSongToPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST.getName(),deleteSongFromPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST.getName(),deletePlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST.getName(),loadPlaylistcommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG.getName(),playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG.getName(),previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG.getName(),nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG.getName(),stopSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONGS.getName(),listSongCommand);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
