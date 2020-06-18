# ImagesSubRedditViewer

ImagesSubRedditViewer is an unofficial app for browsing a specific subreddit /r/images.
The app will load up the subreddit url, and display all the posts as a list of images in the UI.
For the assignment, the app will be split into two, :app and :imageloader. 

app is app section with all designs and screens and flows.
imageloader  is an image loading library with the following specifications written as a library module.

Url used for images "https://www.reddit.com/r/images/hot.json"


Specs for imageloader:

Able to asynchronously load the image onto the ImageView.
Able to load the images faster by caching it in memory.
Able to load the images faster by using disk-level caching.
Able to cancel the on-flight load request in case the loading is not needed anymore.

Specs for :app

Load the subreddit url and parse the response.
Display images from the response in a list
On clicking any image in the list, open it in full screen





