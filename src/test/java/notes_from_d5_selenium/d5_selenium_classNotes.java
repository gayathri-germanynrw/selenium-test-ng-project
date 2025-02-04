package notes_from_d5_selenium;

public class d5_selenium_classNotes {
    /*
    Today's Schedule:
    - Review:
        - Xpath review
        - Xpath interview questions
        - Xpath new functionalities
            - indexing
            - handle dynamic attribute values
            - how to move from child to parent
    - Tasks shared 1,2,3
    - TestNG introduction
    - Dropdowns



-----------------------------------------------------------------------------------------

- Whats is xpath?
    - XPATH is one of 8 locators of Selenium.
    - XPATH allows us to create custom locators.
    - We can use any attribute and any attribute value to create our own custom locator.
    - Xpath can move from parent to child and child to parent


- How do we move from parent to direct child?
    - We use "/" single slash to move to direct child

1-    <div id="uh98">
2-        <div>
3-            <a href="https://google.com"> Google 1 </a>
4-        </div>
5-        <div>
6-            <a href="https://google.com"> Google 2 </a>
7-        </div>
8-        <div>
9-            <a href="https://google.com"> Google 3 </a>
10-        </div>

    </div>

ex#1: write locator returning #2 using "/"

    //div[@id='uh98']/div

ex#2: write locator returning #3 using "/"
    //div[@id='uh98']/div/a

ex#3: write locator returning #5
    //div[@id='uh98']/div   --> 1 of 3
    (//div[@id='uh98']/div)[2] --> This would return us the 2nd div (line #5)





- How do we move to any child using xpath?
    - We use "//" double slash to move to any child.

- What does "//" means in xpath?
    - It means jump to the point I will be giving to you.
    - Or start from anywhere.

- Indexing using xpath locator:
    - If there are more than 1 matching results for an xpath locator, we can use indexes to select exactly which one we want.

    <div>
        <a href="https://google.com"> Google 1 </a>
        <a href="https://google.com"> Google 2 </a>
        <a href="https://google.com"> Google 3 </a>

    </div>

    ex: //a[@href='https://google.com'] --> this will return me 3 matching results.

    - I can use indexes to select exactly a specific one.


    (//a[@href='https://google.com'])[1] ---> returns Google 1
    (//a[@href='https://google.com'])[2] ---> returns Google 2
    (//a[@href='https://google.com'])[3] ---> returns Google 3

    - For xpath indexes start from 1



- How do we move from child to parent?
- We use "/.."
- We do not have to provide any tag name when we are moving from child to parent.
- It will automatically move to direct parent

1-    <div id="uh98">
2-        <div>
3-            <a href="https://google.com"> Google 1 </a>
4-        </div>
5-        <div>
6-            <a href="https://google.com"> Google 2 </a>
7-        </div>
8-        <div>
9-            <a href="https://google.com"> Google 3 </a>
10-        </div>
11- </div>

ex: Locate Google 2 link using its text with xpath

1-    //a[.='Google 2'] --> this locator is returning me line 6

2-    //a[.='Google 2']/..  --> this locator is returning me line 5

3- //a[.='Google 2']/../.. --> this locator is returning me line 1


//E[@A='t']
//tagName[@attribute='value']

--> P.I.Q:
     - How do you handle dynamic web elements?
    - How do you handle web elements with dynamic attribute value?

    - Dynamic attribute value: means some part of an attribute value is changing when the page is refreshed.

Answer#1: we use xpath methods: contains, starts-with, and ends-with

1-    //tagName[contains(@attribute, 'value')]
2-    //tagName[starts-with(@attribute, 'value')]
3-    //tagName[ends-with(@attribute, 'value')]

Answer#2: we can also locate a static (stable) parent or child web element, locate that, and move to desired web element.

genk12034789102348971234
genk98012731098237102933

 1                2



0ahUKEwj6seyij4L2AhWejYkEHRdZBUMQ39UDCAY
0ahUKEwiY2L7wj4L2AhVzkokEHRqzCo4Q39UDCAY


//input[contains(@data-ved, '0ahUK')]
     */
}
