# Foreground-Service-with-Notification

A foreground service performs some operation that is noticeable to the user. For example, an audio app would use a foreground service to play an audio track.
Foreground services must display a Notification. 
Foreground services continue running even when the user isn't interacting with the app.

-> For Strating forground service
step 1 -> Create BaseApllication class and create a notification channel.
step 2 -> Create a service class
step 3 -> add application and service in manifest and also take forground permission.
step 4 -> Start a service from activity.
