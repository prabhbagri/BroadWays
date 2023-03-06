# Broadways

## *Track the most-rated shows currently playing on Broadway*

**Broadways** displays all the shows currently being played on Broadway in New York.
Going on the Broadway website you are not able to view how popular the shows are from real time users
and not based on how many ticket sales each show has. With **Broadways**, you are 
able to view a user's ratings for each show playing on Broadway. The interface
of this applications has a rating of 5 stars shown where you are able to pick how many starts you believe
the Broadway show you have watched deserves. After viewing the Broadway Show from the home screen, you are able to
also view a description of the Broadway Show quoted from the show itself and the current ratings
to get a better idea of the show you will
be watching. This app would attract users from all around 
the world. Broadway shows is a staple to see when in New York. Not only is this attractive
to people in New York but tourists visiting New York. This project interests me from my obsession with Broadway 
shows and wanting to find the best ones to watch to make sure I was getting my money's worth 
with my limited time during my trip. This application would allow us to make 
someone's trip to New York stress-free and transform someone's Broadway experience. 
Introducing *Broadways*!

In the context of a "Broadway Show" rater application:
- As a user, I want to be able to add a rating to the current shows displayed out of 5 star
- As a user, I want to be able to view the current shows playing on Broadway
- As a user, I want to be able to view the ratings given to the Broadway show 
- As a user, I want to be able to select a Broadway Show and see a description of the show
- As a user, I want to be able to add a show that includes an id, title,
description, rating, to the current list of already playing shows on Broadway
- As a user, I want to be able to save my list of Broadway shows with the current ones to file
- As a user, I want to be able to load my list and view all shows on file 
- As a user, I want to be able to remove a show from my Broadway Show List

Phase 4: Task 2

Loaded My Broadway Show List from ./data/BroadwayShows.json
Loaded My Broadway Show List from ./data/BroadwayShows.json
1	Hamilton				|The story of America then, told by America now.|				1
2	Chicago				|Satire on corruption in the administration of criminal justice.|				1
3	Wicked				|Highlighting the importance of healthy and mutual female support systems.|				1
4	Waitress the Musical				|A baker and waitress in an abusive relationship with her husband.|				1
5	The Oh, Hello Show				Comedy Act created by John Mulaney and Nick Kroll				4
Hamilton added in Broadway Show List
Fri Nov 26 13:19:25 PST 2021
Chicago added in Broadway Show List
Fri Nov 26 13:19:25 PST 2021
Wicked added in Broadway Show List
Fri Nov 26 13:19:25 PST 2021
Waitress the Musical added in Broadway Show List
Fri Nov 26 13:19:25 PST 2021
The Oh, Hello Show added in Broadway Show List
Fri Nov 26 13:20:20 PST 2021
The Lion King added in Broadway Show List
Fri Nov 26 13:20:55 PST 2021
West Side Story added in Broadway Show List
Fri Nov 26 13:21:02 PST 2021
Removed show in Broadway Show List
Fri Nov 26 13:21:04 PST 2021
Removed show in Broadway Show List

Phase 4: Task 3

- I would simplify BroadWaysApp and BroadwayShowUI since both of them have a relationship 
with JsonReader, JsonWriter, and BroadwayShowList. I would add one of the these two 
functions into one class. So these classes should be merged with one another because 
of code redundancy.