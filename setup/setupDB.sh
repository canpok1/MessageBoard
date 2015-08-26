sudo -u postgres psql MessageBoard < `dirname $0`/sql/create.sql
