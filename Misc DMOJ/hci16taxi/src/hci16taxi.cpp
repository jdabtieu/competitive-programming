#include <bits/stdc++.h>
/* 
 * Copy-pasting code is NOT cool! Please do not copy and paste my code as a submission to DMOJ.
 * github.com/jdabtieu/competitive-programming
 */
using namespace std;

int main() {
    int nodes, edges, start, pause, stop; scanf("%d%d%d%d%d", &nodes, &edges, &start, &pause, &stop);

	vector<vector<pair<int, int>>> weight;
	for (int i = 0; i <= nodes; i++) weight.push_back(vector<pair<int, int>>());

	for (int i = 0; i < edges; i++) {
		int from, to, cost; scanf("%d%d%d", &from, &to, &cost);
		weight.at(from).push_back(make_pair(to, cost));
		weight.at(to).push_back(make_pair(from, cost));
	}

	long path[++nodes];
	for (int i = 0; i < nodes; i++) path[i] = 1099511627776L;
	path[pause] = 0;

	queue<pair<int, int>> queue;
	queue.push(make_pair(pause, 0));
	while (!queue.empty()) {
		pair<int, int> current = queue.front();
		queue.pop();

		for (int i = 0; i < weight.at(current.first).size(); i++) {
			if (path[current.first] + weight.at(current.first).at(i).second < path[weight.at(current.first).at(i).first]) {
				path[weight.at(current.first).at(i).first] = path[current.first] + weight.at(current.first).at(i).second;
				queue.push(weight.at(current.first).at(i));
			}
		}
	}
	if (path[start] == 1099511627776L) {
		printf("Nooooooooo!!!\n");
		return 0;
	} else if (path[stop] == 1099511627776L) {
		if (path[start] <= 10) {
			printf("%ld\n", 3 + 2 * path[start]);
		} else {
    		printf("%ld\n", 13 + path[start]);
		}
		printf("Yippee!!!\n");
		return 0;
	}
	if (path[start] + path[stop] <= 10) {
		printf("%ld\n", 3 + 2 * (path[start] + path[stop]));
	} else {
		printf("%ld\n", 13 + path[start] + path[stop]);
	}
}