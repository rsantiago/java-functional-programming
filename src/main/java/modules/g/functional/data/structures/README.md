# Functional Data Structures
In functional programming, these are qualities of data structures:
- Immutability - The structure is unable to change
- Persistence - When you use a method to change the state of a structure, it produces a modified copy of itself
  - The interesting thing is, it reuses the former structure, so that I doesn't have to clone the whole structure
- Referentially Transparent - For the same inputs, the output will allways be the same in any place
  - No need to put logs or anything
- No Destructive Updates - It is impossible to loose data while updating a functional data structure