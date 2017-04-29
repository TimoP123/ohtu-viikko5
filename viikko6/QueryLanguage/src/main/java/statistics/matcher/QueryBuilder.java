package statistics.matcher;

public class QueryBuilder {

    Matcher query;

    public QueryBuilder() {
        this.query = new And();
    }

    public Matcher build() {
        Matcher result = this.query;
        return result;
    }

    public QueryBuilder playsIn(String team) {
        this.query = new And(query, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.query = new And(query, new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.query = new And(query, new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.query = new Or(matchers);
        return this;
    }

}
