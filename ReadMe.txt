

Useful git commnads

1) git status : to see the status

2) git add <fileName>

ex : git add *.java

3) git commit -m "your message here"


4) git push --all


Branching in git 

1) Git show all branchs 

git show-branch

-a all
-r remote
2) git checkout -b SpDB

this will create a branch SpDB


3) git checkout master
go back to master when done 

4) git merge SpDB

5) Pushing brnach to remote
git push origin SpDB

git push <remote-name> <branch-name>

MongoCollection<Document> collection = database.getCollection(colName);
MongoCursor<Document> cursor = collection.find()
                                         .sort(new Document("$natural",1)
                                         .cursorType(CursorType.TailableAwait);




