package ru.yamoney.apollo.services.notifier;

import ru.yamoney.apollo.services.notifier.gen.NotifyRequest;
import ru.yamoney.apollo.services.notifier.gen.NotifyResponse;

/**
 * NotifierAPI
 * <p>
 *     Api of notifier service
 * </p>
 * @author Platonov Alexey
 * @version 1.0 28.10.2015
 * @see <a href="https://wiki.yamoney.ru/pages/viewpage.action?pageId=90315392">Notifier</a>
 */
public interface INotifierAPI {

    /**
     * Service response codes
     */
    enum ResponseCode {
        SUCCESS(0);

        private final int responseCode;

        ResponseCode(int responseCode) {
            this.responseCode = responseCode;
        }

        /**
         * Get status code
         *
         * @return code
         */
        public int getCode() {
            return responseCode;
        }
    }

    /**
     * Send notify to user
     *
     * @param request           notify information
//     * @param commandContext    rest command context
     * @return operation result
//     * @throws BadGatewayException if error occurred on service side while command executes
     */
    NotifyResponse notify(NotifyRequest request/*, RESTCommandContext commandContext*/) /*throws BadGatewayException*/;
}
