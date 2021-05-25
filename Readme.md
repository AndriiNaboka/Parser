The basic requirement is to provide a program that can convert text into comma separated (CSV) data.
The text is to be parsed, broken into sentences and words and the words have to be sorted. For
simplicity, please treat “.”, “?” and “!” as the end of sentences.
The program must be able to input text like:

“Mary had a little lamb. Peter called for the wolf, and Aesop came.
Cinderella likes shoes.”
and convert to a CSV format.
The parsing must break the text into sentences and words. The parser should allow some whitespace
around words and delimiters, e.g. the following is allowed as input and should produce the same result
as the first example:

“ Mary had a little lamb .

Peter called for the wolf , and Aesop came .
Cinderella likes shoes.”

In both cases the CSV result should be like:
, Word 1, Word 2, Word 3, Word 4, Word 5, Word 6, Word 7, Word 8
Sentence 1, a, had, lamb, little, Mary
Sentence 2, Aesop, and, called, came, for, Peter, the, wolf
Sentence 3, Cinderella, likes, shoes

To start app:

The Simplest way is to start Main inside ide.

Also it's possible to compile and start jar
For this you need maven.

If you want executable jar
1) Open terminal
1) Install maven
2) Change directory where pom is located
3) Execute mvn clean package
4) Change directory to target directory where jar is located
5) Execute command java -jar Parser-1.0-SNAPSHOT-jar-with-dependencies.jar

Software parse input from console and provide output to the console also.

Example:
Enter text to parse: 
Hello World
Word 1, Word 2
Sentence 0, Hello, World

App terminated by word exit.
