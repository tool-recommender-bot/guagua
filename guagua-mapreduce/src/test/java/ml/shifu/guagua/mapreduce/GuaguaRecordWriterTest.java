/*
 * Copyright [2013-2014] PayPal Software Foundation
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ml.shifu.guagua.mapreduce;

import java.io.IOException;

import ml.shifu.guagua.mapreduce.GuaguaRecordWriter;

import org.apache.hadoop.io.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuaguaRecordWriterTest {

    private GuaguaRecordWriter writer;

    @Before
    public void setUp() {
        writer = new GuaguaRecordWriter();
    }

    @Test
    public void testClose() {
        try {
            writer.close(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testWrite() {
        try {
            writer.write(new Text(), new Text());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        writer = null;
    }

}
