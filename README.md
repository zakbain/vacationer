### Purpose (Pitch) ###
Remember the last time you planned a vacation. For months, you searched all the best places to go 
and saved them in separate tabs and notebooks. Then, you travel to the destination, excited to 
see all the cool places. Then, you finally get on the flight and arrive in your destination. 
You're walking the beautiful streets of St. Petersburg, when you realize all your notes are in separate
places. And you can't remember where you saved everything. Only weeks later do you find it scribbled
on the back of your notebook. And you forgot to visit your grandmother's favorite museum.

To solve this problem, I present to you: Vacationer. Vacationer is an App for saving all your travel
destinations and events in one place. Simply log in and add events that you are interested in doing
during your visit. That's it. Everything is saved in one place. You can easily edit the events
as plans change and mark them as complete once you are done with the event.

But there's more. With the next version, Vacationer will present a Social Media and Recommendations 
Engine. You will be able to share any events you are interested in with your entire web of friends. 
You will find that many of your friends love hearing about the events that you are going to. And 
they can recommend new ideas! Who knows? Your friend from Columbus may have been to the same coffee 
shops in St. Petersburg. If you're still having trouble deciding what to do, we are introducing 
a cutting edge AI platform to recommend new events. Vacationer will be your new travel buddy!

### Target Market ###
There are two core markets for this product. First, tech-savvy individuals who are already used to sharing
and getting travel ideas from the internet. They currently use Instagram and various blogs to get ideas.
But it's not personalized, and it's not easy to save all the information in one place. 

Secondly, people who travel a lot but do not have a large online presence. These people will find it very 
helpful to see all the information in one place. They'll find that keeping track of events with Vacationer 
is easier thand doing so with pen and paper. They'll also find it as a way to start conversations with 
people online whom they may have barely interacted.


### Technical Details ###
As far as technical details, the front and back-end is developed using cutting edge Java Frameworks
such as Spring-Boot and Thymeleaf. The data is saved in a MySQL Database, and all interactions
are secured using Spring-Security! The AI is implemented using Scikit-learn, a python library.
Finally, the phone app will be available in all platforms using React-Native.


### How to run ###
 * Open terminal
 * Change directory to the root 
 * mvn spring-boot:run

### Special Instruction ###
Username: user
Password: password

### Things Learned ###
I learned how important it is to implement an MVP of all pieces before enhancing any one piece. When
I first started, I had grand ideas of really enhancing the Java Backend. I wanted events to be stored 
per each individual user (rather than a generic login). I wanted to generate a report and schedule 
of events. But, I quickly realized there wasn't much time and switched to implementing a different
layer of the application - UI tweaks.
 