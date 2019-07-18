# BootCamp
This Repository contains all the files pertaining to Khoros Boot-camp

To download the repository: git clone https://github.com/Prashanth-TR/BootCamp.git
The Java project does the following functions:
1. Get input from the user and post it as a Tweet.
2. Get the current "timeline" from the user's newsfeed and print it in the console.

Twitter4J is an unofficial Java library for the Twitter API using which the program performs the above tasks.
Here dropWizard Java Framework was used to perform GET and POST operations using REST-API.

To post a tweet:
1. Run the main function.
2. Open terminal and enter: curl -d "<your tweet>" -X POST http://localhost:8080//twitter-api/1.0/tweet

To gert your current timeline:
1. Run the main function.
2. Open an browser and type http://localhost:8080//twitter-api/1.0/timeline
3. If you are using chrome, JSONView extension is recommended for readability.
