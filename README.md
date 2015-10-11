
# _Hair Salon_

_Description: Basic website for keeping track of hairdressers with multiple clients. October 10th, 2015_

#### By **Maggie O'Neill**

## add Hairdresser and clients to database
## update Hairdresser and clients in database
## delete clients from database


_In PSQL:
_Create database salon._
_CREATE TABLE hairdresser (id serial PRIMARY KEY, name varchar);
CREATE TABLE clients (id serial PRIMARY KEY, client_name varchar, hairdress_id int)

_JUnit and FluentLenium are used for testing. Velocity is used to created web page templates. Spark is used to run the_
_program on a local server._

## Project Setup

1. _Download zip file and update directory names to correspond to your project._
2. _In terminal, move to main directory "salon-master"_
3. _Run psql_
4. _In psql tab, Enter salon < salon.sql_
5._In bash tab, Enter "gradle run"_
6._In your web browser, navigate to http://localhost:4567/



## Testing

1. _running 'gradle test' from the base directory  will run both unit and integration tests_

## License

Copyright (c) 2015 **Maggie O'Neill**

This software is licensed under the MIT license.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
