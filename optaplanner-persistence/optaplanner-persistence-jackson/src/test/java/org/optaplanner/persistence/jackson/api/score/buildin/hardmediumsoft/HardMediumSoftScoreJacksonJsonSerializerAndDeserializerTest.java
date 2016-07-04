/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.persistence.jackson.api.score.buildin.hardmediumsoft;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.junit.Test;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
import org.optaplanner.persistence.jackson.api.score.AbstractScoreJacksonJsonSerializerAndDeserializerTest;
import org.optaplanner.persistence.jackson.api.score.ScoreJacksonJsonSerializer;

public class HardMediumSoftScoreJacksonJsonSerializerAndDeserializerTest extends AbstractScoreJacksonJsonSerializerAndDeserializerTest {

    @Test
    public void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestHardMediumSoftScoreWrapper(null));
        HardMediumSoftScore score = HardMediumSoftScore.valueOfInitialized(1200, 30, 4);
        assertSerializeAndDeserialize(score, new TestHardMediumSoftScoreWrapper(score));
        score = HardMediumSoftScore.valueOf(-7, 1200, 30, 4);
        assertSerializeAndDeserialize(score, new TestHardMediumSoftScoreWrapper(score));
    }

    public static class TestHardMediumSoftScoreWrapper extends TestScoreWrapper<HardMediumSoftScore> {

        @JsonSerialize(using = ScoreJacksonJsonSerializer.class)
        @JsonDeserialize(using = HardMediumSoftScoreJacksonJsonDeserializer.class)
        private HardMediumSoftScore score;

        @SuppressWarnings("unused")
        private TestHardMediumSoftScoreWrapper() {
        }

        public TestHardMediumSoftScoreWrapper(HardMediumSoftScore score) {
            this.score = score;
        }

        @Override
        public HardMediumSoftScore getScore() {
            return score;
        }

    }

}
