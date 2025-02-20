package org.yuezhikong.geminisdk;

import lombok.Getter;
import lombok.Setter;

public class Types {
    @Getter
    @Setter
    public class ContentConfig {
        private String[] stopSequences;

        private String responseMimeType;

        private int candidateCount;

        private int maxOutputTokens;

        private float temperature;

        private float topP;

        private int topK;

        private int seed;

        private float presencePenalty;

        private float frequencyPenalty;

        private boolean responseLogprobs;

        private int logprobs;

        private boolean enableEnhancedCivicAnswers;
    }
}
