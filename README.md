# Collection Manager
This software is a tool to manage TV shows and movies collections.

## Origin
This software is developped for a course taking place at UCBL - IUT Lyon 1 (Bourg-en-Bresse), France. It is developped by three students preparing a Computer Science DUT (second year).

### Authors
* Anthony Correia <anthony.correia71@gmail.com>
* Orann Weber <orann.weber@gmail.com>
* Thibaud Sabatier <thibaud.sabatier@gmail.com>

## Data fetching
Currently, all data cencerning shows and movies is fetched from themoviedatabase.org, using the free API they provide.
**This product uses the TMDb API but is not endorsed or certified by TMDb.**

### Caching
All data fetched from TMDB's API is stored locally on the disk. It avoids fetching several times the same data.

### Wrapper
There are several wrappers for themoviedatabase's API which already exist for many languages (including Java). However, I decided not to use any existing wrapper and created my own.


