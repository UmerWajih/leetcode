package main

func areSentencesSimilar(sentence1 []string, sentence2 []string, similarPairs [][]string) bool {
	if len(sentence1) != len(sentence2) {
		return false
	}
	//store wods from similar pair in a map
	l := make(map[string][]string)

	for _, vals := range similarPairs {
		l[vals[0]] = append(l[vals[0]], vals[1])
		l[vals[1]] = append(l[vals[1]], vals[0])
	}

	for index := range sentence1 {
		if sentence1[index] == sentence2[index] {
			continue
		}

		value, exists := l[sentence1[index]]
		if !exists {
			return false
		}
		found := false
		for _, val := range value {
			if val == sentence2[index] {
				found = true
				break
			}
		}
		if !found {
			return false
		}
	}
	return true

}
