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
package ml.shifu.guagua.worker;

import ml.shifu.guagua.io.Bytable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link TraceWorkerInterceptor} is used to trace whole application process.
 * 
 * @param <MASTER_RESULT>
 *            master result for computation in each iteration.
 * @param <WORKER_RESULT>
 *            worker result for computation in each iteration.
 */
public class TraceWorkerInterceptor<MASTER_RESULT extends Bytable, WORKER_RESULT extends Bytable> extends
        BasicWorkerInterceptor<MASTER_RESULT, WORKER_RESULT> {

    private static final Logger LOG = LoggerFactory.getLogger(TraceWorkerInterceptor.class);

    @Override
    public void preIteration(WorkerContext<MASTER_RESULT, WORKER_RESULT> context) {
        LOG.debug("pre application:{}, container:{}, iteration:{}, context:{}", context.getAppId(),
                context.getContainerId(), context.getCurrentIteration(), context);
    }

    @Override
    public void postIteration(WorkerContext<MASTER_RESULT, WORKER_RESULT> context) {
        LOG.debug("post application:{}, container:{}, iteration:{}, context:{}", context.getAppId(),
                context.getContainerId(), context.getCurrentIteration(), context);
    }

    @Override
    public void preApplication(WorkerContext<MASTER_RESULT, WORKER_RESULT> context) {
        LOG.debug("pre application:{}, container:{}, context:{}", context.getAppId(), context.getContainerId(), context);
    }

    @Override
    public void postApplication(WorkerContext<MASTER_RESULT, WORKER_RESULT> context) {
        LOG.debug("post application:{}, container:{}, context:{}", context.getAppId(), context.getContainerId(),
                context);
    }

}
