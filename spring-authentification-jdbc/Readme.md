## Problem

Until now, we have been saving the logging user credentials into the in-memory application, therefore,
the users info was created each time we run the application and lost when we stop it.

## Solution

Store the user credentials into a Database, persisting their username and encoded password and use them later,
without losing the user´s info even when we stop the application.