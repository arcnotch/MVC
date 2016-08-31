package algorithms.search;

public interface Searcher<T> {
    /**
     * This method gets a Searchable object and
     * searches the end from the start in the way implemented
     * @param s This is the Searchable type object
     * @return Solution<T> This returns Solution object
     */
    public Solution<T> search(Searchable<T> s);
    /**
     * This method get how many nodes were evaluated by the search algorithm
     * @return int This returns the number of nodes evaluated in the search
     */
    public int getNumberOfNodesEvaluated();
}