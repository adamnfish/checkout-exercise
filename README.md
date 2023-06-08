Pre-interview exercise
======================

The solution to the exercise is here, with git tags for step-1 and
step-2 (visible on Github above the files panel).

# Running the code

You can run the checkout program from your terminal using sbt.

    $ sbt "run apple apple orange"

The easiest way to perform repeated runs of the program is to use the
sbt shell.

    $ sbt
    > run [fruit ..]

e.g.

    > run apple apple apple orange

The program will calculate the cost of the provided items, and print
that cost to the terminal.

# Tests

The tests can be executed from your terminal or using the sbt shell.

    $ sbt test
    
    > test
