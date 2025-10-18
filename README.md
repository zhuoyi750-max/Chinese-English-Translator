# Translator Application

A Java-based translator program that converts English sentences into Chinese using the official HSK (汉语水平考试) vocabulary dataset.  
This project focuses on building translation logic algorithmically — without external APIs — to strengthen understanding of data structures, string manipulation, and algorithm design.

---

## Overview

The Translator Application reads from a `.csv` file containing **2,244 HSK-level Chinese words** across multiple grammatical categories.  
Each line includes:
Word Type, Chinese, Pinyin, English


The program takes English sentences as input, searches for word matches in the HSK dataset, and outputs the translated Chinese sentence.  
It continues translating until the user types `stop translating`.

---

## Core Features

- **CSV Data Integration:** Reads and processes vocabulary data directly from the provided `HSK_Words.csv` file.  
- **Custom Translation Algorithm:** Translates English sentences into Chinese without using APIs or hardcoded phrases.  
- **Continuous Interaction:** Accepts multiple sentences until the user chooses to stop.  
- **Word Type Handling:** Recognizes various parts of speech (noun, verb, adjective, conjunction, etc.).  
- **Advanced Sentence Support:** Can handle conjugated verbs and plurals through algorithmic identification.

---

## Technical Highlights

- **Language:** Java  
- **Data File:** `HSK_Words.csv`  
- **Key Classes & Methods:**
  - `Translator.java` — Main logic and user interface.
  - `Word.java` — Defines structure for each vocabulary entry.
  - `CSVReader.java` — Loads and parses HSK data.
  - `ConjugationHandler.java` — Handles verb and plural detection for more natural translation.

---

## Project Structure

/translator-project/
│
├── Translator.java # Main program
├── Word.java # Word object definition
├── CSVReader.java # Reads and parses CSV data
├── ConjugationHandler.java # Handles verb and plural forms
├── HSK_Words.csv # Dataset (Levels 1–5)
└── README.md # Documentation
