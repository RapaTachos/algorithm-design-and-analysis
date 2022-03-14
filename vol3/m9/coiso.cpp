#include <cstdio>
#include <queue>

using namespace std;

typedef struct
{
        int x, y, day;
} Map;

const int MAX = 1000;
int dimX, dimY, nAirports, first, last;
char map[MAX][MAX];
queue<Map> solve;

void input ()
{
        Map newCloud;
        scanf ("%d %d", &dimX, &dimY);
        for ( int i = 0; i < dimY; i++ )
        {
                scanf ("%s", map[i]);
                for ( int j = 0; j <= dimX; j++ )
                {
                        if ( map[i][j] == 'A' ) nAirports++;
                        else if ( map[i][j] == '#' )
                        {
                                newCloud.x = j;
                                newCloud.y = i;
                                newCloud.day = 1;
                                solve.push (newCloud);
                        }
                }
        }
}

void add (int x, int y, int day)
{
        Map newCloud;
        newCloud.x = x;
        newCloud.y = y;
        newCloud.day = day;
        solve.push (newCloud);
}

void bfs ()
{
        int attacked = 0, days = 0;
        Map newCloud;
        while ( nAirports >= 0 )
        {
                days++;
                int size = solve.size ();
                for ( int i = 0; i < size; i++ )
                {
                        newCloud = solve.front ();
                        solve.pop ();
                        if ( map[newCloud.x][newCloud.y] == 'A' )
                        {
                                attacked++;
                                nAirports--;
                                if ( attacked == 1 ) first = days;
                        }
                        if ( newCloud.x < dimX ) add (newCloud.x + 1, newCloud.y, newCloud.day + 1);
                        if ( newCloud.x > 0 ) add (newCloud.x - 1, newCloud.y, newCloud.day + 1);
                        if ( newCloud.y > 0 ) add (newCloud.x, newCloud.y - 1, newCloud.day + 1);
                        if ( newCloud.y < dimY ) add (newCloud.x, newCloud.y + 1, newCloud.day + 1);
                }
        }
        last = days;
}

int main ()
{
        input ();
        bfs ();
        printf ("%d %d\n", first, last);
        return 0;
}
